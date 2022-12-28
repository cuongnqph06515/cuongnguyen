import { Component, ViewChild } from '@angular/core';
import { AgGridAngular } from 'ag-grid-angular';
import { ColDef } from 'ag-grid-community';

@Component({
  selector: 'app-demo-ag-grid',
  templateUrl: './demo-ag-grid.component.html',
  styleUrls: ['./demo-ag-grid.component.scss']
})
export class DemoAgGridComponent {

  @ViewChild('agGrid') agGrid!: AgGridAngular;

  defaultColDef: ColDef = {
    sortable: true,
    filter: true
  };

  columnDefs : ColDef[] = [
    { field: 'make', rowGroup: true},
    { field: 'model'},
    { field: 'price'}
  ];

  rowData = [
    { make: 'Toyota', model: 'Celica', price: 35000 },
    { make: 'Toyota', model: 'Celica', price: 2000 },
    { make: 'Toyota', model: 'Celica', price: 35000 },
    { make: 'Toyota', model: 'Celica', price: 2000 },
    { make: 'Ford', model: 'Mondeo', price: 32000 },
    { make: 'Porsche', model: 'Boxter', price: 72000 }
  ];

  //Cài đặt Group Column
  autoGroupColumnDef = {
    headerName: 'Model',
    field: 'make',
    cellRenderer: 'agGroupCellRenderer',
    cellRendererParams: {
        checkbox: true
    }
  };

  public constructor(){

  }

  getSelectedRows(): void {
    const selectedNodes = this.agGrid.api.getSelectedNodes();
    const selectedData = selectedNodes.map(node => node.data.make+ " " + node.data.model).join(', ');
    // const selectedDataStringPresentation = selectedData
    //             .map(node => `${node.make} ${node.model}`)
    //             .join(', ');
    alert(`Selected nodes: ${selectedData}`);
  }

  clearSelection(){
    this.agGrid.api.deselectAll();
  }

  onCellClicked(event: any){
    console.log(event);
    
  }
}
