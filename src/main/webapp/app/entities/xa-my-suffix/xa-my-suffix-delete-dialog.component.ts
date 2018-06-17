import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { XaMySuffix } from './xa-my-suffix.model';
import { XaMySuffixPopupService } from './xa-my-suffix-popup.service';
import { XaMySuffixService } from './xa-my-suffix.service';

@Component({
    selector: 'jhi-xa-my-suffix-delete-dialog',
    templateUrl: './xa-my-suffix-delete-dialog.component.html'
})
export class XaMySuffixDeleteDialogComponent {

    xa: XaMySuffix;

    constructor(
        private xaService: XaMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.xaService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'xaListModification',
                content: 'Deleted an xa'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-xa-my-suffix-delete-popup',
    template: ''
})
export class XaMySuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private xaPopupService: XaMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.xaPopupService
                .open(XaMySuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
