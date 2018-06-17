import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { XaMySuffix } from './xa-my-suffix.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<XaMySuffix>;

@Injectable()
export class XaMySuffixService {

    private resourceUrl =  SERVER_API_URL + 'api/xas';

    constructor(private http: HttpClient) { }

    create(xa: XaMySuffix): Observable<EntityResponseType> {
        const copy = this.convert(xa);
        return this.http.post<XaMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(xa: XaMySuffix): Observable<EntityResponseType> {
        const copy = this.convert(xa);
        return this.http.put<XaMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<XaMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<XaMySuffix[]>> {
        const options = createRequestOption(req);
        return this.http.get<XaMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<XaMySuffix[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: XaMySuffix = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<XaMySuffix[]>): HttpResponse<XaMySuffix[]> {
        const jsonResponse: XaMySuffix[] = res.body;
        const body: XaMySuffix[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to XaMySuffix.
     */
    private convertItemFromServer(xa: XaMySuffix): XaMySuffix {
        const copy: XaMySuffix = Object.assign({}, xa);
        return copy;
    }

    /**
     * Convert a XaMySuffix to a JSON which can be sent to the server.
     */
    private convert(xa: XaMySuffix): XaMySuffix {
        const copy: XaMySuffix = Object.assign({}, xa);
        return copy;
    }
}
