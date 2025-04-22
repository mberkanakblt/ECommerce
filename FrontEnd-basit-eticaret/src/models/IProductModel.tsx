import { JSX } from "react/jsx-runtime";

interface IProductModel {
    map(arg0: (product: any, index: any) => JSX.Element): import("react").ReactNode;
    id: number;
    ad: string;
    kategoriAdi: string;
    fiyat: number;
    resim: string;
    stok: number;
}
export default IProductModel;