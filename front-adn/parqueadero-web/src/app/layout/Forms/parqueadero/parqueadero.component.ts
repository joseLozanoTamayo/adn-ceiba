import { Component, OnInit } from '@angular/core';
import { petitionservice } from 'src/app/shared/services/petitions';
import swal from 'sweetalert2';

/**
 *
 */
export interface Parqueadero {

    id: string;
    cilindraje: string;
    estado: string;
    horaIngreso: string;
    horaSalida: string;
    nombresPropietario: any;
    pagoCancelado: any;
    placaVehiculo: string;
    empleado: any;
    tipoVehiculo: TipoVehiculo;
    valorCilindraje: string;
    pagoTotal: string;
    config: object;

}

/**
 *
 */
export class TipoVehiculo {

    id: string;
    codigo: string;
    cupo: string;
    diasPermitidos: string;
    placaBloqueada: string;
    vehiculo: any;

}

export interface Error {
    title: string;
    status: string;
    detail: string;
    timeStamp: Date;
    developerMessage: string;
}

/**
 *
 */
export class Empleado {

    id: string;
    nombres: string;
    apellidos: string;
    cargo: string;

}

@Component({
    selector: 'app-parqueadero',
    templateUrl: './parqueadero.component.html',
    styleUrls: ['./parqueadero.component.scss']
})
export class ParqueaderoComponent implements OnInit {

    public datos: Parqueadero;
    public selectMode = false;
    public tipoVehiculo: TipoVehiculo[] = new Array<TipoVehiculo>();
    public empleado: Empleado;

    private URL_GET_TIPO_VEHICULO = 'tipovehiculo/obtenerlista';
    private URL_POST_PARQUEADERO = 'parqueadero/crear';
    private URL_POST_PROCESAR_PAGO = 'parqueadero/obtenerparqueadero';
    private URL_POST_PARQUEADERO_REGISTRO = 'parqueadero/regitrarpago';

    constructor(public api: petitionservice) {
       this.setValue();
    }

    ngOnInit() {
        this.consultarTipoVehiculo();
        this.empleado = new Empleado();
        this.empleado.id = '1';
    }

    private setValue() {
        this.datos = {
            id : '',
            cilindraje : '',
            estado : '',
            horaIngreso : '',
            horaSalida : '',
            nombresPropietario : '',
            pagoCancelado : '',
            placaVehiculo : '',
            empleado : new Empleado(),
            tipoVehiculo : new TipoVehiculo(),
            valorCilindraje: '',
            pagoTotal: '',
            config: {
                titulo: 'Parqueadero', path: 'parqueadero/obtenerLista', data: [
                    {
                        nombre: 'serial',
                        dato: 'id'
                    },
                    {
                        nombre: 'Nombres',
                        dato: 'nombresPropietario'
                    },
                    {
                        nombre: 'Hora Ingreso',
                        dato: 'horaIngreso'
                    },
                    {
                        nombre: 'Hora Salida',
                        dato: 'horaSalida'
                    },
                    {
                        nombre: 'eliminar',
                        dato: 'idInmueble'
                    }
                ]
            }
        };
    }

    /**
     *
     * @param item
     */
    rowSelect(item) {
        console.log(' DATA SELECT ' + JSON.stringify(item));
        this.selectMode = true;
        this.datos.id = item['serial'];

        this.api.ejecutarPost(this.URL_POST_PROCESAR_PAGO, JSON.stringify(this.datos)).then(
            res => {
                console.log('res ', res);
                this.datos =  res;
                // this.vehiculo = this.datos.tipoVehiculo;
            }
        );

        this.consultarTipoVehiculo();

    }

    /**
     * Crea registros
     */
    crear() {
        this.selectMode = true;

    }

    /**
     * guarda registros de propietario
     */
    guardar() {

        this.datos.estado = !this.datos.id ? 'ASIGNADO' : 'CANCELADO';
        this.datos.empleado = this.empleado;

        const URL_REST = !this.datos.id ? this.URL_POST_PARQUEADERO : this.URL_POST_PARQUEADERO_REGISTRO;

        this.api.ejecutarPost( URL_REST, JSON.stringify(this.datos))
        .then(
                res => {
                    const error: Error = res;
                    const type = !error ? 'success' : 'error';
                    const mensaje = !error ? 'REGISTRO EXITOSO' : error.detail;
                    this.selectMode = true;
                    swal({
                        type: type,
                        title: mensaje,
                        showConfirmButton: true,
                        timer: 3000,
                    }).then (
                        val => {
                            this.setValue();
                            this.selectMode = false;
                        }
                    );
                }
            );
    }

    /**
     *
     */
    private consultarTipoVehiculo() {
        this.api.ejecutarGet(this.URL_GET_TIPO_VEHICULO).then(
			res => {
                this.tipoVehiculo = res;
                // this.datos.tipoVehiculo = this.tipoVehiculo[0];
			}
		);
    }
}
