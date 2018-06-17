/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { TestJhipster2TestModule } from '../../../test.module';
import { CuaHangDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/cua-hang/cua-hang-delete-dialog.component';
import { CuaHangService } from '../../../../../../main/webapp/app/entities/cua-hang/cua-hang.service';

describe('Component Tests', () => {

    describe('CuaHang Management Delete Component', () => {
        let comp: CuaHangDeleteDialogComponent;
        let fixture: ComponentFixture<CuaHangDeleteDialogComponent>;
        let service: CuaHangService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [TestJhipster2TestModule],
                declarations: [CuaHangDeleteDialogComponent],
                providers: [
                    CuaHangService
                ]
            })
            .overrideTemplate(CuaHangDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(CuaHangDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CuaHangService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(Observable.of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
