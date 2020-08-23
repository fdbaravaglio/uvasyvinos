import { Component, OnInit } from '@angular/core';
import { ElementService } from '../shared/elements/elements.service';
import { Element } from '../shared/entities/Element';


@Component({
  selector: 'app-element-list',
  templateUrl: './element-list.component.html',
  styleUrls: ['./element-list.component.scss']
})
export class ElementListComponent implements OnInit {

  elements: Array<any>;
  displayedColumns = ['id', 'name'];

  constructor(private elementService: ElementService) { }

  ngOnInit(): void {
    this.elementService.getAll().subscribe(data => {
      this.elements = data;
    })
  }

}
