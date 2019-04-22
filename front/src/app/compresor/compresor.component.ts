import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';



const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'},{'Content-Type':'application/json'},{'Access-Control-Allow-Origin':'*'},{'Access-Control-Allow-Headers':'Content-Type'}),
	observe: 'body',
	responseType: 'json'
}

@Component({
  selector: 'app-compresor',
  templateUrl: './compresor.component.html',
  styleUrls: ['./compresor.component.css']
})
export class CompresorComponent implements OnInit {

texto: string;
compressed: string;
  constructor(private  httpClient:HttpClient) { }

  ngOnInit() {
  }

compress (): Observable<string> {
this.httpClient.post("https://compressor-237218.appspot.com/compress",
{
"value": this.texto
},{httpOptions})
.subscribe(
data  => {
this.compressed = data.compressed;
},
error  => {
console.log('ERROR RECIBIDO: ',error);
this.compressed = error.mensaje;
}
);
}



}
