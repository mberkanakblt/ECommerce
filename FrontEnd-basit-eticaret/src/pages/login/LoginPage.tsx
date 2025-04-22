import React, {useState} from 'react'
import './style.css'
import swal from 'sweetalert'
import { useNavigate } from 'react-router'

function LoginPage() {
	const navigation = useNavigate();
  /**
   *  ./ -> bulunduğun dizin demektir.
   *  ../ -> bulunduğun dizinin bir üst dizini demektir.
   *  / -> en üst dizine git demektir.
   */
  	const [email, setemail] = useState('')
	const [password, setpassword] = useState('')
	const login = ()=>{
		fetch('http://localhost:9090/dev/v1/kullanici/login',{
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({email,password})
		}).then(res=> res.json())
		.then(response=> {
			if(response.code === 200){ //login olmuştur
				/**
				 * token bilgisi lokal storage a yazılır.
				 * 
				 */
				sessionStorage.setItem('token', response.data);
				navigation('/')

			}else{ // bir hata var
				swal('HATA!', response.message, 'error')
			}
		})
	}
  return (
    <div className="wrapper" 
      style={{backgroundImage: 'url("/img/bg-registration-form-2.jpg")'}}>
			<div className="inner">
				<form action="">
					<h3>Login Page</h3>
					
					<div className="form-wrapper">
						<label >Email</label>
						<input type="text" className="form-control" onChange={evt=> setemail(evt.target.value)} />
					</div>
					<div className="form-wrapper">
						<label >Password</label>
						<input type="password" className="form-control" onChange={evt=> setpassword(evt.target.value)} />
					</div>
					
					<button type='button' onClick={login}>Login</button>

					<div className='form-wrapper mt-3 text-center'>
						<a href="/register">create new account</a>
					</div>
				</form>
			</div>
		</div>
  )
}

export default LoginPage