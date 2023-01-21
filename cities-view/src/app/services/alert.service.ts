import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class AlertService {

  constructor(private toaster: ToastrService) { }

  alertSuccess(mensagem: string) {
    this.toaster.success(mensagem, '', {
      timeOut: 2000,
    });
  }
  alertError(mensagem: string) {
    this.toaster.error(mensagem, '', {
      timeOut: 2000,
    });
  }

  alertWarning(mensagem: string) {
    this.toaster.warning(mensagem, '', {
      timeOut: 2000,
    });
  }
}
