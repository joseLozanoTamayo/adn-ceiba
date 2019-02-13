import { PERSONModule } from './person.module';

describe('CGPAISESModule', () => {
    let personModule: PERSONModule;

    beforeEach(() => {
        personModule = new PERSONModule();
    });

    it('should create an instance', () => {
        expect(personModule).toBeTruthy();
    });
});
