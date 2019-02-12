import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { InmuebleComponent } from './inmueble.component';

const routes: Routes = [
    { path: '', component: InmuebleComponent }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class CgInmuebleRoutingModule {}
