import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatFormFieldModule, MatPaginatorModule, MatIconModule } from '@angular/material';
import { MatInputModule, MatButtonModule } from '@angular/material';
import { MatTableModule } from '@angular/material';
import { ParqueaderoTableComponent } from './parqueaderoTable.component';

@NgModule({
    imports: [
        CommonModule,
        MatFormFieldModule,
        MatPaginatorModule,
        MatTableModule,
        MatInputModule,
        MatButtonModule,
        MatIconModule
    ],
    declarations: [ParqueaderoTableComponent],
    exports: [ParqueaderoTableComponent]
})
export class ParqueaderoTableModule {}
