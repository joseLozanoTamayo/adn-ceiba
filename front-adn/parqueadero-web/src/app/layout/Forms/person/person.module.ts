import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { CgPaisesRoutingModule } from './person-routing.module';
import { PersonComponent } from './person.component';
import { PersonalTableModule } from './../../components/personalTable/personalTable.module';
import { FormsModule } from '@angular/forms';


@NgModule({
    imports: [CommonModule,
        CgPaisesRoutingModule,
        PersonalTableModule,
        FormsModule
    ],
    declarations: [PersonComponent],
    exports: [PersonComponent]
})
export class PERSONModule { }
