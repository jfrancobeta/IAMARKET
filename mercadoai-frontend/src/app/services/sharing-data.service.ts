import { EventEmitter, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharingDataService {

  private _handlerLoginEvent = new EventEmitter();
  constructor() { }

  get handlerLoginEvent() {
    return this._handlerLoginEvent;
  }
}
