import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { SimpleChange } from '@angular/core';
import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting } from '@angular/common/http/testing';
import { provideMockStore } from '@ngrx/store/testing';

import { CourseCard } from './course-card';

describe('CourseCard', () => {
  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseCard],
      providers: [
        provideHttpClient(),
        provideHttpClientTesting(),
        provideMockStore({
          initialState: {
            course: { courses: [], loading: false, error: null },
            enrollment: { enrolledCourseIds: [] }
          }
        })
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CourseCard);
    component = fixture.componentInstance;
  });

  // Step 102: should create
  it('should create', () => {
    component.course = {
      id: 1,
      name: 'Test Course',
      code: 'TEST101',
      credits: 3,
      gradeStatus: 'passed',
      enrolled: false
    };
    fixture.detectChanges();
    expect(component).toBeTruthy();
  });

  // Step 103: Test for @Input rendering
  it('should display the course name in h3 header', () => {
    component.course = {
      id: 1,
      name: 'Data Structures',
      code: 'CS101',
      credits: 4,
      gradeStatus: 'passed',
      enrolled: false
    };
    fixture.detectChanges();
    const element = fixture.debugElement.query(By.css('h3')).nativeElement;
    expect(element.textContent).toContain('Data Structures');
  });

  // Step 104: Test for @Output
  it('should emit enrollRequested on enroll button click', () => {
    component.course = {
      id: 1,
      name: 'Data Structures',
      code: 'CS101',
      credits: 4,
      gradeStatus: 'passed',
      enrolled: false
    };
    fixture.detectChanges();
    spyOn(component.enrollRequested, 'emit');

    const button = fixture.debugElement.query(By.css('.actions button')).nativeElement;
    button.click();
    fixture.detectChanges();

    expect(component.enrollRequested.emit).toHaveBeenCalledWith(1);
  });

  // Step 105: Test for ngOnChanges
  it('should log to console on course property changes', () => {
    spyOn(console, 'log');
    const prev = undefined;
    const curr = {
      id: 1,
      name: 'Data Structures',
      code: 'CS101',
      credits: 4,
      gradeStatus: 'passed',
      enrolled: false
    };

    component.ngOnChanges({
      course: new SimpleChange(prev, curr, true)
    });

    expect(console.log).toHaveBeenCalled();
  });
});

