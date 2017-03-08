package cn.gtgs.base.OTO.activity.Address.view;

import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.Address.model.Address;
import cn.gtgs.base.OTO.activity.Address.presenter.IAddressActionLisenter;


/**
 * Created by gtgs on 2017/2/15.
 */

public class AddressAdatper extends RecyclerView.Adapter<AddressAdatper.ViewHolder> {

    private ArrayList<Address> mAddresses;
    private IAddressActionLisenter addressChanged;
    private IAddressActionLisenter itemLisenter;

    public AddressAdatper(ArrayList<Address> addresses, IAddressActionLisenter itemLisenter) {
        this.mAddresses = addresses;
        this.itemLisenter = itemLisenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_address_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Address address = mAddresses.get(position);
        holder.mTvDelete.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        holder.mTvModify.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        holder.mCheDefault.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        holder.mTvName.setText(address.getFirst_name());
        holder.mTvPhone.setText(address.getPhone_number());
        holder.mTvAddress.setText(address.getAddress());
        holder.mTvModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != itemLisenter) {
                    itemLisenter.modifyItem(mAddresses.get(position));
                }
            }
        });
        holder.mTvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemLisenter.deleteItem(mAddresses.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAddresses.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox mCheDefault;
        TextView mTvName;
        TextView mTvPhone;
        TextView mTvAddress;
        TextView mTvDelete;
        TextView mTvModify;
        CardView cardView;

        public ViewHolder(View v) {
            super(v);
            mCheDefault = (CheckBox) v.findViewById(R.id.che_layout_item_address_content_default);
            mTvName = (TextView) v.findViewById(R.id.tv_layout_item_address_content_name);
            mTvPhone = (TextView) v.findViewById(R.id.tv_layout_item_address_content_phone);
            mTvAddress = (TextView) v.findViewById(R.id.tv_layout_item_address_content_address);
            mTvDelete = (TextView) v.findViewById(R.id.tv_layout_item_address_content_delete);
            mTvModify = (TextView) v.findViewById(R.id.tv_layout_item_address_content_modify);
            cardView = (CardView) v.findViewById(R.id.cardview_layout_item_address_content);
        }
    }
}
