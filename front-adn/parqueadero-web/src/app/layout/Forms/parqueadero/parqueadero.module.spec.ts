import { ParqueaderoModule } from './parqueadero.module';

describe('CGPAISESModule', () => {
    let parqueaderoModule: ParqueaderoModule;

    beforeEach(() => {
        parqueaderoModule = new ParqueaderoModule();
    });

    it('should create an instance', () => {
        expect(parqueaderoModule).toBeTruthy();
    });
});
