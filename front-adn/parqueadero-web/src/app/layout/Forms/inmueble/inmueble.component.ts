import { Component, OnInit } from '@angular/core';
import { petitionservice } from 'src/app/shared/services/petitions';
import swal from 'sweetalert2';

export interface Inmueble {
    idInmueble: string;
    direccion: string;
    estrato: string;
    metraje: string;
    propietario: string;
    valor: any;
    config: object;
}
@Component({
    selector: 'app-inmueble',
    templateUrl: './inmueble.component.html',
    styleUrls: ['./inmueble.component.scss']
})
export class InmuebleComponent implements OnInit {

    public datos: Inmueble;
    public selectMode = false;

    constructor(public api: petitionservice) {
        this.datos = {
            idInmueble: '',
            direccion: '',
            estrato: '',
            metraje: '',
            propietario: '',
            valor: 0,
            config: {
                titulo: 'Inmueble', path: 'inmueble/obtenerinmueble', data: [
                    {
                        nombre: 'Nombre',
                        dato: 'nombre'
                    },
                    {
                        nombre: 'direccion',
                        dato: 'direccion'
                    },
                    {
                        nombre: 'valor',
                        dato: 'valor'
                    },
                    {
                        nombre: 'eliminar',
                        dato: 'idInmueble'
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
        this.datos.idInmueble = '';
        this.datos.direccion = 'M';
        this.datos.estrato = '';
        this.datos.metraje = '';
        this.datos.propietario;
        this.datos.valor = null;
    }

    /**
     * guarda registros de propietario
     */
    guardar() {
        if (this.datos.idInmueble) {
            this.api.ejecutarPost('inmueble/crear', {
                'direccion': (this.datos.direccion) ,
                'estrato': this.datos.estrato,
                'metraje': this.datos.metraje,
                'propietario': this.datos.propietario,
                'valor': this.datos.valor,
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
