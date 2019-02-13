import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class sessionService {
    private user = {};
	constructor() {
        this.user = JSON.parse(localStorage.getItem('user')) ? JSON.parse(localStorage.getItem('user')) : {};
	}
}
