import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { personalTableComponent } from './personalTable.component';

describe('personalTableComponent', () => {
    let component: personalTableComponent;
    let fixture: ComponentFixture<personalTableComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [personalTableComponent]
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(personalTableComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
