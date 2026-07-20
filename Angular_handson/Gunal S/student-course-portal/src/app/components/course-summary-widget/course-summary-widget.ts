import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseService } from '../../services/course';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-course-summary-widget',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './course-summary-widget.html',
  styleUrl: './course-summary-widget.css',
})
export class CourseSummaryWidget implements OnInit, OnDestroy {
  courseCount = 0;
  private sub: Subscription | null = null;

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    this.refreshCount();
  }

  ngOnDestroy(): void {
    if (this.sub) {
      this.sub.unsubscribe();
    }
  }

  refreshCount(): void {
    if (this.sub) {
      this.sub.unsubscribe();
    }
    this.sub = this.courseService.getCourses().subscribe({
      next: (courses) => {
        this.courseCount = courses.length;
      },
      error: (err) => console.error('Summary widget failed to get courses:', err)
    });
  }

  addMockCourse(): void {
    const nextId = Math.floor(Math.random() * 1000) + 10;
    this.courseService.createCourse({
      name: `Mock Course ${nextId}`,
      code: `MOCK${nextId}`,
      credits: 3,
      gradeStatus: 'pending',
      enrolled: false
    }).subscribe({
      next: () => {
        this.refreshCount();
      },
      error: (err) => console.error('Summary widget failed to create course:', err)
    });
  }
}
