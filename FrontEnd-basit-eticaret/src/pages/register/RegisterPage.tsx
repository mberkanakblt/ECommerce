import React, {useState} from 'react'
import './style.css'
import swal from 'sweetalert'
function RegisterPage() {
  /**
   * Verileri okumak için değişklenler tanımla
   * bu değişkenleri inputlardan al
   * fetch ile sunucuya bu değerleri gönder
   * dönüş data sını kontrol et ve sonucu yazdır.
   * {
  "ad": "muhammet",
  "telefon": "stringstri",
  "email": "muhammet@gmail.com",
  "password": "Aa123456*",
  "rePassword": "Aa123456*"
}
   */
  const [ad, setad] = useState('')
  const [telefon, settelefon] = useState('')
  const [email, setemail] = useState('')
  const [password, setpassword] = useState('')
  const [rePassword, setrePassword] = useState('')
  const register = ()=>{
      if(password !== rePassword) {
        swal('Dikkat','Şifreler uyuşmuyor', 'error');
      }else{
        fetch('http://localhost:9090/dev/v1/kullanici/register',{
          method: 'POST',
          headers:{
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({ad,telefon,email,password,rePassword})
        }).then(res=> res.json())
        .then(response=> {
          if(response.data){ // üyelik başarılı
              swal('Bildirim!', response.message, 'success')
          }else{ // bir hata var
              swal('HATA!!', response.message, 'error' );
          }
        })
      }
  }
  return (
    <div className="wrapper" 
    style={{backgroundImage: 'url("/img/bg-registration-form-2.jpg")'}}>
    <div className="inner">
      <form>
        <h3>Registration Form</h3>
        <div className="form-group">
          <div className="form-wrapper">
            <label >Full Name</label>
            <input type="text" className="form-control" onChange={evt=> setad(evt.target.value)}/>
          </div>
        </div>
        <div className="form-wrapper">
          <label >Email</label>
          <input type="text" className="form-control" onChange={evt=> setemail(evt.target.value)}/>
        </div>
        <div className="form-wrapper">
          <label >Phone</label>
          <input type="text" className="form-control" onChange={evt=> settelefon(evt.target.value)}/>
        </div>
        <div className="form-wrapper">
          <label >Password</label>
          <input type="password" className="form-control" onChange={evt=> setpassword(evt.target.value)}/>
        </div>
        <div className="form-wrapper">
          <label >Confirm Password</label>
          <input type="password" className="form-control" onChange={evt=> setrePassword(evt.target.value)}/>
        </div>
        <div className="checkbox">
          <label>
            <input type="checkbox" /> I caccept the Terms of Use & Privacy Policy.
            <span className="checkmark"></span>
          </label>
        </div>
        <button type='button' onClick={register}>Register Now</button>
        <div className='form-wrapper mt-3 text-center'>
						<a href="/login">go to login</a>
				</div>
      </form>
    </div>
  </div>
  )
}

export default RegisterPage