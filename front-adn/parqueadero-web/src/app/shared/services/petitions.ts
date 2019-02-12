import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError} from 'rxjs/operators';



// httpOptions for set header options
const httpOptions = {
	headers: new HttpHeaders({
	  'Accept': 'application/json',
	  'Content-Type': 'application/json;'
	}),
  };

@Injectable()
export class petitionservice {
	private path = '';
	private token = '1';

	constructor(private http: HttpClient) {
		this.path = 'http://localhost:8082';
	}

	public get(url: string): Observable<any> {
		const  header = new HttpHeaders(
			{
				'authorization': this.token
			}
		);
		const opciones = {
			'headers': header
    	};

		return this.http.get(this.path + '/' + url, opciones);
	}

	public delete(url: string, id: string): Observable<any> {
		const  header = new HttpHeaders(
			{
				'authorization': this.token
			}
		);
		const opciones = {
			'headers': header
    	};

		return this.http.delete(this.path + '/' + url + '/' + id, opciones);
	}

	public post(url: string, body: any): Observable<any> {
		const  header = new HttpHeaders(
			{
				'Content-Type': 'application/json'
			}
		);
		const opciones = {
			'headers': header,
			'body': body
    	};

		return this.http.post(this.path + '/' + url, opciones);
	}

	public getId(url: string, id: string): Observable<any> {
		const  header = new HttpHeaders(
			{
				'authorization': this.token
			}
		);
		const opciones = {
			'headers': header
    	};

		return this.http.get(this.path + '/' + url + '/' + id, opciones);
	}

	/**
	 * ejecutarGet
	 */
	public ejecutarGet(url: string) {
		console.log('URL' + url );
		return this.get2(url).toPromise().then(
			(res) => {
				return res;
			},
			err => {
				return err;
			}
		);
	}
	/**
	 * ejecutarDelete
	 */
	public ejecutarDelete(url: string, id: string) {
		return this.delete(url, id).toPromise().then(
			(res) => {
				return res;
			},
			(err) => {
				return err;
			}
		);
	}
	/**
	 * ejecutarGetId
	 */
	public ejecutarGetId(url: string, id: string) {
		return this.getId(url, id).toPromise().then(
			(res) => {
				return res;
			},
			(err) => {
				return err;
			}
		);
	}
	/**
	 * ejecutarPost
	 */
	public ejecutarPost(url, body) {

		console.log(' BODY : ' + JSON.stringify(body));
		if ( body instanceof Object) {
			body = JSON.stringify(body);
		}

		return this.post2(url, body).toPromise().then(
			res => {
				console.log(' response : ' + JSON.stringify(res));
				return res;
			},
			(err) => {
				return err;
			}
		);
	}

	/**
	 * Metodo pos que registra propietarios
	 * @param endpoint
	 * @param element
	 */
	post2(endpoint, element) {

		return this.http.post( this.path + '/' + endpoint, element, httpOptions).pipe(
		  catchError(this.handleError)
		);
	  }

	  /**
	   *
	   * @param endpoint
	   */
	  get2(endpoint) {
		return this.http.get(this.path + '/' + endpoint, httpOptions).pipe(
		  catchError(this.handleError)
		);
	  }

	private handleError(error: HttpErrorResponse) {

		console.error(' ERROR : ' + error);

		if (error.error instanceof ErrorEvent) {
		  // A client-side or network error occurred. Handle it accordingly.
		  console.error('An error occurred:', error.error.message);
		} else {
		  // The backend returned an unsuccessful response code.
		  // The response body may contain clues as to what went wrong,
		  console.error(
			`Backend returned code ${error.status}, ` +
			`body was: ${error.error}`);
		}
		// return an observable with a user-facing error message
		return throwError(
		  'Something bad happened; please try again later.');
	  }
}
