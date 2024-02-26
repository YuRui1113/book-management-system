/**
 * File: src\app\components\shared\form-helper.ts
 * Project: WebFront
 * Created Date: Monday, February 26th 2024, 3:40:45 pm
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Monday, 26th February 2024 10:29:16 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2024 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Monday, February 26th 2024	Rui Yu		Initial version
 */

import { FormGroup } from '@angular/forms';

export class FormHelper {

    MANDATORY_MESSAGE = 'Field {0} is required';

    isFieldInvalid(formControlName: string, formGroup: FormGroup): boolean {
        let isValid = false;

        const abstractControl = formGroup.get(formControlName);
        if (abstractControl) {
            isValid = abstractControl.invalid && (abstractControl.dirty || abstractControl.touched);
        }

        return isValid;
    }
}