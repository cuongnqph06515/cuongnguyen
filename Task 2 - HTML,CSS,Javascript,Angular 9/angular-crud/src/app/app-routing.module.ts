import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DemoAgGridComponent } from './pages/demo-ag-grid/demo-ag-grid.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/welcome' },
  { path: 'welcome', loadChildren: () => import('./pages/welcome/welcome.module').then(m => m.WelcomeModule) },
  { path: 'ag-grid', component: DemoAgGridComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
