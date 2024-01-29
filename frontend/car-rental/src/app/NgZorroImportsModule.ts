import { NgModule } from '@angular/core';
import { NzSpinModule } from 'ng-zorro-antd/spin';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzSelectModule} from 'ng-zorro-antd/select';
import {NzTimePickerModule} from 'ng-zorro-antd/time-picker';
import {NzDatePickerModule} from 'ng-zorro-antd/date-picker';


@NgModule({
   exports:[
    NzSpinModule,
    NzFormModule,
    NzInputModule,
    NzLayoutModule,
    NzButtonModule,
    NzSelectModule,
   NzDatePickerModule,
   NzTimePickerModule
   
   ]
})

export class NgZorroImportsModule {}