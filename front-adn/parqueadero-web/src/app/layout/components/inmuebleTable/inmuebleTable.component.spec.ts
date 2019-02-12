import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { inmuebleTableComponent } from './inmuebleTable.component';

describe('inmuebleTableComponent', () => {
    let component: inmuebleTableComponent;
    let fixture: ComponentFixture<inmuebleTableComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [inmuebleTableComponent]
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(inmuebleTableComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
