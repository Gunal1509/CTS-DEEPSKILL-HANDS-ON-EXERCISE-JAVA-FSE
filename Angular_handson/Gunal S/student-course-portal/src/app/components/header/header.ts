import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { AuthService } from '../../services/auth';

// HANDS-ON 1 - Task 2, Step 7: nav with portal name + placeholder links.
@Component({
  selector: 'app-header',
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {
  constructor(public authService: AuthService) {}

  toggleAuth(): void {
    if (this.authService.isLoggedIn) {
      this.authService.logout();
    } else {
      this.authService.login();
    }
  }
}
