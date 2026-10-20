import { Routes } from '@angular/router';
import {LayoutComponent} from './features/layout/layout.component';

export const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: '',
        pathMatch: 'full',
        redirectTo: 'dashboard',
      },
      {
        path: 'dashboard',
        loadChildren: () =>
          import('./modules/dashboard/dashboard.routes').then((m) => m.DASHBOARD_ROUTES)
      }
    ]
  }
];
