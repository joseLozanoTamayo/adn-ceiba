import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { routerTransition } from '../router.animations';
import {petitionservice} from '../shared/services/petitions';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [routerTransition()]
})
export class LoginComponent implements OnInit {
    public cedula = '';
    public pass = '';

    constructor(
        private translate: TranslateService,
        public router: Router,
        public api: petitionservice
        ) {
            this.translate.addLangs(['en', 'fr', 'ur', 'es', 'it', 'fa', 'de', 'zh-CHS']);
            this.translate.setDefaultLang('en');
            const browserLang = this.translate.getBrowserLang();
            this.translate.use(browserLang.match(/en|fr|ur|es|it|fa|de|zh-CHS/) ? browserLang : 'en');
    }

    /**
     * metodo init de la clase login
     */
    ngOnInit() {
        localStorage.clear();
    }

    /**
     * metodo action para evento de login
     */
    onLoggedin() {
 /*       if (this.cedula && this.pass) {
            this.api.ejecutarPost('usuario/login', {cedula: this.cedula, clave: this.pass} ).then(
                res => {
                    if (res['nombre']) {
                        res['id'] = this.cedula;
                        localStorage.setItem('user', JSON.stringify(res));
                        localStorage.setItem('isLoggedin', 'true');
                        // this.router.navigateByUrl('dashboard');
                    }
                }
                ) ;
        }
*/
        // localStorage.setItem('user', JSON.stringify(res));
        localStorage.setItem('isLoggedin', 'true');
        this.router.navigateByUrl('dashboard');
    }
}
