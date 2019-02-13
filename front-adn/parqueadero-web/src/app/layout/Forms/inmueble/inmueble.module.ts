import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { CgInmuebleRoutingModule } from './inmueble-routing.module';
import { InmuebleComponent } from './inmueble.component';
// import { InmuebleTableModule } from './../../components/inmuebleTable/inmuebleTable.module';
import { InmuebleTableComponent } from '../../components/inmuebleTable/inmuebleTable.component';
import { FormsModule } from '@angular/forms';
import { InmuebleTableModule } from '../../components/inmuebleTable/inmuebleTable.module';


@NgModule({
    imports: [CommonModule,
        CgInmuebleRoutingModule,
        InmuebleTableModule,
        FormsModule
    ],
    declarations: [InmuebleComponent],
    exports: [InmuebleComponent]
})
export class InmuebleModule { }
