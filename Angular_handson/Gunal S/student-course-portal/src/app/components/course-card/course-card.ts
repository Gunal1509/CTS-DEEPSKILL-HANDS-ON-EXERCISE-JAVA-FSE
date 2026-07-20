import { CommonModule } from '@angular/common';
import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  Output,
  SimpleChanges,
} from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { map, take } from 'rxjs/operators';
import { Course } from '../../models/course.model';
import { Highlight } from '../../directives/highlight';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';
import { EnrollmentService } from '../../services/enrollment';
import { enrollInCourse, unenrollFromCourse } from '../../store/enrollment/enrollment.actions';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';

@Component({
  selector: 'app-course-card',
  imports: [CommonModule, Highlight, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css',
})
export class CourseCard implements OnChanges {
  @Input() course!: Course;
  @Output() enrollRequested = new EventEmitter<number>();
  @Output() viewDetails = new EventEmitter<number>();
  isExpanded = false;

  enrolledIds$: Observable<number[]>;

  constructor(
    private store: Store,
    private enrollmentService: EnrollmentService
  ) {
    this.enrolledIds$ = this.store.select(selectEnrolledIds);
  }

  onCardClick(event: Event): void {
    const target = event.target as HTMLElement;
    if (target.tagName === 'BUTTON') {
      return;
    }
    this.viewDetails.emit(this.course.id);
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log(
        'CourseCard ngOnChanges — previous:',
        changes['course'].previousValue,
        'current:',
        changes['course'].currentValue,
      );
    }
  }

  toggleExpanded(): void {
    this.isExpanded = !this.isExpanded;
  }

  onEnrollClick(): void {
    this.enrolledIds$.pipe(take(1)).subscribe((ids) => {
      const currentlyEnrolled = ids.includes(this.course.id);
      if (currentlyEnrolled) {
        this.store.dispatch(unenrollFromCourse({ courseId: this.course.id }));
        this.enrollmentService.unenroll(this.course.id);
      } else {
        this.store.dispatch(enrollInCourse({ courseId: this.course.id }));
        this.enrollmentService.enroll(this.course.id);
      }
      this.enrollRequested.emit(this.course.id);
    });
  }

  get gradeBorderStyle(): Record<string, string> {
    const colours: Record<Course['gradeStatus'], string> = {
      passed: '#16a34a',
      failed: '#dc2626',
      pending: '#296ce1',
    };
    return { 'border-left-color': colours[this.course.gradeStatus] };
  }

  get cardClasses(): Record<string, boolean> {
    return {
      'card--full': this.course.credits >= 4,
      expanded: this.isExpanded,
    };
  }
}
