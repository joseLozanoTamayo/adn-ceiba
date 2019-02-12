import { Component, OnInit } from '@angular/core';
import { petitionservice } from 'src/app/shared/services/petitions';
import swal from 'sweetalert2';

export interface Persona {
    id: string;
    nombre: string;
    apellido: string;
    cedula: string;
    celular: string;
    sexo: string;
    pais: string;
    config: object;
}
@Component({
    selector: 'app-person',
    templateUrl: './person.component.html',
    styleUrls: ['./person.component.scss']
})
export class PersonComponent implements OnInit {

    public datos: Persona;
    public selectMode = false;

    constructor(public api: petitionservice) {
        this.datos = {
            id: '',
            nombre: '',
            apellido: '',
            cedula: '',
            sexo: 'masculino',
            pais: 'colombia',
            celular: null,
            config: {
                titulo: 'PROPIETARIOS', path: 'propietario/obtenerpropietario', data: [
                    {
                        nombre: 'Nombre',
                        dato: 'nombre'
                    },
                    {
                        nombre: 'cedula',
                        dato: 'cedula'
                    },
                    {
                        nombre: 'Telefono',
                        dato: 'nombre'
                    },
                    {
                        nombre: 'eliminar',
                        dato: 'cedula'
                    }
                ]
            }
        };
    }
    ngOnInit() {
    }

    rowSelect(item) {
        this.api.ejecutarGetId(this.datos.config['path'], item['codigo']).then(
            res => {
                console.log('res ', res);
            }
        );

    }


    /**
     * Crea registros
     */
    crear() {
        this.selectMode = true;
        this.datos.cedula = '';
        this.datos.sexo = 'M';
        this.datos.nombre = '';
        this.datos.apellido = '';
        this.datos.pais === 'Colombia';
        this.datos.celular = null;
    }

    /**
     * guarda registros de propietario
     */
    guardar() {
        if (this.datos.cedula) {
            this.api.ejecutarPost('propietario/crear', {
                'cedula': this.datos.cedula,
                'sexo': (this.datos.sexo === 'Femenino') ? 'F' : 'M',
                'nombre': this.datos.nombre,
                'apellido': this.datos.apellido,
                'indicativo': (this.datos.pais === 'Colombia') ? '57' : '00',
                'telefono': this.datos.celular,
            }).then(
                res => {
                    this.selectMode = true;
                    swal({
                        type: 'success',
                        title: 'REGISTRO EXITOSO',
                        showConfirmButton: true,
                        timer: 3000,
                    }).then (
                        val => {
                            this.selectMode = false;
                        }
                    );
                }
            );

        }
    }
}
