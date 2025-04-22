import { ChangeEventHandler } from "react";

export interface IRegisterModel {
    onChange: ChangeEventHandler<HTMLInputElement> | undefined;
   ad: string;
  adres: string,
  email: string,
  telefon: string,
  password: string,
  repassword: string,
  avatar: string
}