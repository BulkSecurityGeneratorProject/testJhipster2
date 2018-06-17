/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { TestJhipster2TestModule } from '../../../test.module';
import { HuyenMySuffixDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/huyen-my-suffix/huyen-my-suffix-delete-dialog.component';
import { HuyenMySuffixService } from '../../../../../../main/webapp/app/entities/huyen-my-suffix/huyen-my-suffix.service';

describe('Component Tests', () => {

    describe('HuyenMySuffix Management Delete Component', () => {
        let comp: HuyenMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<HuyenMySuffixDeleteDialogComponent>;
        let service: HuyenMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [TestJhipster2TestModule],
                declarations: [HuyenMySuffixDeleteDialogComponent],
                providers: [
                    HuyenMySuffixService
                ]
            })
            .overrideTemplate(HuyenMySuffixDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(HuyenMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(HuyenMySuffixService);
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
