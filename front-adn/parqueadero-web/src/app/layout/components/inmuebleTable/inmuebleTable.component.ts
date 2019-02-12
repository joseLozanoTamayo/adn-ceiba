import { Component, OnInit, ViewChild, Input, SimpleChanges, Output, EventEmitter } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { SelectionModel } from '@angular/cdk/collections';
import { petitionservice } from 'src/app/shared/services/petitions';
import swal from 'sweetalert2';
import {  delay } from 'rxjs/operators';


@Component({
	selector: 'app-inmuebleTable',
	templateUrl: './inmuebleTable.component.html',
	styleUrls: ['./inmuebleTable.component.scss']
})
export class InmuebleTableComponent implements OnInit {

	@Input() configuracion: any;
	@ViewChild(MatPaginator) paginator: MatPaginator;
	@ViewChild(MatSort) sort: MatSort;
	@Output() dataSelect = new EventEmitter<any>();
	@Output() dataNew = new EventEmitter<any>();
	public displayedColumns = [];
	public data = [];
	public view = false;
	public eliminar = false;
	dataSource: MatTableDataSource<any>;
	selection = new SelectionModel<any>(true, []);
	constructor(public api: petitionservice) {
	}


	ngOnInit() {
		console.log(' ONINIT ');
		this.loadData();
	}

	loadData() {
		this.api.ejecutarGet(this.configuracion.path).then(
			res => {
				this.data = [];
				this.displayedColumns = [];
				this.displayedColumns.push('n°');
				for (const item of this.configuracion.data) {
					this.displayedColumns.push(item.nombre);
				}
				if (res) {
					for (const dato in res) {
						const obj = {};
						obj['n°'] = Number(dato) + 1;
						for (const item of this.configuracion.data) {
							obj[item.nombre] = res[dato][item.dato];
						}
						this.data = [...this.data, obj];
					}
				}
				this.dataSource = new MatTableDataSource(this.data);
				this.dataSource.paginator = this.paginator;
				this.dataSource.sort = this.sort;
				this.view = true;
			}
		);
	}

	// Filtro de la Tabla
	applyFilter(filterValue: string) {
		filterValue = filterValue.trim(); // Remove whitespace
		filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
		this.dataSource.filter = filterValue;
		if (this.dataSource.paginator) {
			this.dataSource.paginator.firstPage();
		}
	}
	// Seleccion de item en la tabla
	seleccioneItem(row) {
		if (!this.eliminar) {
			this.dataSelect.emit(row);
		}
	}
	// eliminar item en la base de datos
	delete(item) {
		this.eliminar = true;
		// Mensaje de confirmacion
		swal({
			title: 'Desea Borrar este Registro',
			customClass: 'animated ZoomIn',
			type: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			cancelButtonText: 'CANCELAR',
			confirmButtonText: 'ACEPTAR'
		}).then(
			result => {
				if (result) {
					this.api.ejecutarDelete(this.configuracion.path, item['eliminar']).then(
						res => {
						swal({
							type: 'success',
							title: 'REGISTRO ELIMINADO',
							showConfirmButton: false,
							timer: 1500
						});
							this.loadData();
						}
					);
        }
				setTimeout(() => {
					this.eliminar = !this.eliminar;
				}, 200);
			}
		);
	}
	crear() {
		this.dataNew.emit();
	}
}

