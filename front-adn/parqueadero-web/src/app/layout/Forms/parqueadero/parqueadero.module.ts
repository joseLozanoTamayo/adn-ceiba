import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { CgParqueaderoRoutingModule } from './parqueadero-routing.module';
import { ParqueaderoComponent } from './parqueadero.component';
import { ParqueaderoTableComponent } from '../../components/parqueaderoTable/parqueaderoTable.component';
import { FormsModule } from '@angular/forms';
import { ParqueaderoTableModule } from '../../components/parqueaderoTable/parqueaderoTable.module';


@NgModule({
    imports: [CommonModule,
        CgParqueaderoRoutingModule,
        ParqueaderoTableModule,
        FormsModule
    ],
    declarations: [ParqueaderoComponent],
    exports: [ParqueaderoComponent]
})
export class ParqueaderoModule { }
