import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParqueaderoTableComponent } from './parqueaderoTable.component';

describe('ParqueaderoTableComponent', () => {
    let component: ParqueaderoTableComponent;
    let fixture: ComponentFixture<ParqueaderoTableComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [ParqueaderoTableComponent]
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(ParqueaderoTableComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
