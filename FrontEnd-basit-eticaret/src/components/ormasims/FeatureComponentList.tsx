
import FeatureComponent from '../atoms/FaeatureComponent'
function FeatureListComponent() {
  return (
    <div className="container-fluid pt-5">
        <div className="row px-xl-5 pb-3">
            <FeatureComponent icon='fa fa-check'  title='Quality Product'/>
            <FeatureComponent icon='fa fa-shipping-fast'  title='Free Shipping'/>
            <FeatureComponent icon='fa fa-exchange-alt'  title='14-Day Return'/>
            <FeatureComponent icon='fa fa-phone-volume'  title='24/7 Support'/>
        </div>
    </div>
  )
}
 
export default FeatureListComponent