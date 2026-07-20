import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotificationService } from '../../services/notification';

@Component({
  selector: 'app-notification',
  standalone: true,
  imports: [CommonModule],
  // Step 67: Provide NotificationService at component level using providers.
  // This creates a new, separate instance of NotificationService scoped to this component instance.
  providers: [NotificationService],
  templateUrl: './notification.html',
  styleUrl: './notification.css',
})
export class Notification {
  // Explanation:
  // Providing a service at the component level means Angular will create a new instance of this
  // service for each instance of this component. The service instance is tied to the component's
  // lifecycle and is destroyed when the component is destroyed. It is scoped to this component
  // and its child components, creating isolated state per component instance rather than a global singleton.
  constructor(private notificationService: NotificationService) {}

  get notifications(): string[] {
    return this.notificationService.getNotifications();
  }

  addLog(msg: string): void {
    this.notificationService.addNotification(msg);
  }

  clearLogs(): void {
    this.notificationService.clear();
  }
}
