import { inject } from '@angular/core';
import { HttpInterceptorFn } from '@angular/common/http';
import { finalize } from 'rxjs';
import { LoadingService } from '../services/loading.service';

export const loadingInterceptor: HttpInterceptorFn = (req, next) => {
  const loadingService = inject(LoadingService);
  
  // Step 91: Set it to true in intercept before next.handle(req)
  loadingService.show();

  return next(req).pipe(
    // Step 91: and false in the pipe's finalize operator.
    finalize(() => {
      loadingService.hide();
    })
  );
};
