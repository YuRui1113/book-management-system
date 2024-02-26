/**
 * File: src\app\components\shared\paginated.component.ts
 * Project: WebFront
 * Created Date: Monday, February 26th 2024, 12:07:04 pm
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Monday, 26th February 2024 6:54:04 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2024 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Monday, February 26th 2024	Rui Yu		Initial version
 */

import { Injectable } from '@angular/core';
import { Book } from 'src/app/models/book';
import { PaginatedItemsView } from 'src/app/models/paginated-iitems-view';
import { environment } from 'src/environments/environment';

@Injectable()
export class PaginateBaseComponent {

    pageData: PaginatedItemsView<Book> = {
        content: [],
        totalPages: 0,
        totalElements: 0,
        size: 0,
        number: 0,
        last: false,
        first: false,
        numberOfElements: 0,
        empty: true
    };
    pageSize = environment.pageSize;

    constructor() {
    }

    refreshCurrentPage(): void {
        this.fetchPageData(this.pageData.number);
    }

    fetchPageData(pageIndex: number): void {
    }
}