package edu.itch2.dadm_proyectotema4.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import edu.itch2.dadm_proyectotema4.R;

public class MyAdapter extends BaseAdapter {
    private ArrayList<Model> modelArrayList;
    private Context context;
    private int layout;

    // A constructor.
    public MyAdapter(ArrayList<Model> modelArrayList, Context context, int layout) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.layout = layout;
    }

    /**
     * This function returns the number of items in the list.
     * 
     * @return The size of the modelArrayList.
     */
    @Override
    public int getCount() {
        return modelArrayList.size ();
    }

    /**
     * This function returns the item at the specified position in the data set
     * 
     * @param position The position of the item within the adapter's data set of the item whose view we
     * want.
     * @return The position of the item in the array list.
     */
    @Override
    public Object getItem(int position) {
        return modelArrayList.get ( position );
    }

    /**
     * It returns the position of the item in the list.
     * 
     * @param position The position of the item within the adapter's data set of the item whose view we
     * want.
     * @return The position of the item in the list.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * The ViewHolder class is a static inner class that holds the references to the views in the
     * layout
     */
    private class ViewHolder{
        TextView idtxt,titletxt,bodytxt;
    }

    /**
     * The getView() method is called every time the list needs to be displayed
     * 
     * @param position The position of the item within the adapter's data set of the item whose view we
     * want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view is
     * non-null and of an appropriate type before using. If it is not possible to convert this view to
     * display the correct data, this method can create a new view.
     * @param parent The parent that this view will eventually be attached to.
     * @return A View object.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=new ViewHolder ();
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService ( Context.LAYOUT_INFLATER_SERVICE );
        convertView=layoutInflater.inflate ( layout,null );

        viewHolder.idtxt=convertView.findViewById ( R.id.idtxt );
        viewHolder.titletxt=convertView.findViewById ( R.id.titletxt );
        viewHolder.bodytxt=convertView.findViewById ( R.id.bodytxt );

        //set position
        Model model=modelArrayList.get ( position );
        viewHolder.idtxt.setText ("Id:-"+ model.getId ()+ "\n");
        viewHolder.titletxt.setText ("Title:-"+ model.getTitle ()+"\n" );
        viewHolder.bodytxt.setText ( "Body:-"+model.getBody () );
        return convertView;
    }
}
