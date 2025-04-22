import  {useState, useEffect} from 'react'
import ICategoryModel from '../../models/ICategoryModel';
import CategoryComponent from '../molecules/CategoryComponent';
function CategoriesListComponent() {
    /**
     * Burada categoies şeklinde yaptığım dizi bir sunucudan gelmeli
     * mesela RestAPI den gelebilir.
     */
   // img/cat-1.jpg

  const [categories, setCategories] = useState<ICategoryModel[]>([]);
    useEffect(()=>{
      fetch('http://localhost:9090/dev/v1/kategori/get-main-kategori')
      .then(res=> res.json())
      .then(response=> setCategories(response.data))
    },[]);
  return (
    <div className="container-fluid pt-5">
        <div className="row px-xl-5 pb-3">
            {
                categories.map((categori,index)=>{
                    return  <CategoryComponent 
                    key={index}
                    title={categori.ad} 
                    productCount={12} 
                    imageUrl={'img/cat-'+(index%6+1)+'.jpg'} />
                })
            }
        </div>
    </div>
  )
}

export default CategoriesListComponent