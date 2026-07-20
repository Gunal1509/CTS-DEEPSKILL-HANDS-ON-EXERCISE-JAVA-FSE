import { inject } from '@angular/core';
import { HttpInterceptorFn } from '@angular/common/http';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';

export const errorHandlerInterceptor: HttpInterceptorFn = (req, next) => {
  const router = inject(Router);

  return next(req).pipe(
    catchError((error) => {
      // Step 90: if status 401, navigate to login (home); if status 500, show a global error notification
      if (error.status === 401) {
        console.warn('Unauthorized request intercepted. Redirecting to home...');
        router.navigate(['/']);
      } else if (error.status === 500) {
        console.error('Internal server error (500) intercepted.');
        alert('Global Error: Internal Server Error occurred. Please try again later.');
      }
      return throwError(() => error);
    })
  );
};
