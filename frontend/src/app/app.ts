import { TuiRoot } from '@taiga-ui/core';
import { Component } from '@angular/core';
import {RouterOutlet} from '@angular/router';

@Component({
  imports: [TuiRoot, RouterOutlet],
  selector: 'app-root',
  styleUrl: './app.less',
  templateUrl: './app.html',
})
export class App {}
