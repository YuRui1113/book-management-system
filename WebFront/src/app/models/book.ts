/**
 * File: src\app\models\book.ts
 * Project: WebFront
 * Created Date: Monday, February 26th 2024, 11:09:49 am
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Monday, 26th February 2024 10:30:20 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2024 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Monday, February 26th 2024	Rui Yu		Initial version
 */

export interface Book {

    id?: number,
    title: string,
    author: string,
    publicationYear: number,
    isbn: string
}