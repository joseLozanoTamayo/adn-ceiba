import { InmuebleModule } from './inmueble.module';

describe('CGPAISESModule', () => {
    let inmuebleModule: InmuebleModule;

    beforeEach(() => {
        inmuebleModule = new InmuebleModule();
    });

    it('should create an instance', () => {
        expect(inmuebleModule).toBeTruthy();
    });
});
