import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';


import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})


export class App {
  protected readonly title = signal('mi-proyecto');
}
