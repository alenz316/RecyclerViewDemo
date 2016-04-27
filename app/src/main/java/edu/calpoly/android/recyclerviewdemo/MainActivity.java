package edu.calpoly.android.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AnimalUtils.Animal> mAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);

        assert rv != null;

        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        if (savedInstanceState == null) {

            mAnimals = AnimalUtils.getAllTheAnimals();
        } else {
            mAnimals = savedInstanceState.getParcelableArrayList("ANIMALS");
        }
        final AnimalAdapter aa = new AnimalAdapter(mAnimals);
        rv.setAdapter(aa);

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                AnimalViewHolder avh = (AnimalViewHolder) viewHolder;
                if (direction == ItemTouchHelper.RIGHT) {
                    int index = viewHolder.getAdapterPosition();
                    mAnimals.remove(index);
                    aa.notifyItemRemoved(index);
                } else if (direction == ItemTouchHelper.LEFT) {
                    AnimalUtils.Animal a = avh.animal;
                    a.setDangerous(!a.isDangerous());
                    aa.notifyItemChanged(viewHolder.getAdapterPosition());
                }
            }
        };

        new ItemTouchHelper(simpleCallback).attachToRecyclerView(rv);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("ANIMALS", mAnimals);
        super.onSaveInstanceState(outState);
    }

    public static class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {

        private ArrayList<AnimalUtils.Animal> mAnimals;

        public AnimalAdapter(ArrayList<AnimalUtils.Animal> animals) {
            this.mAnimals = animals;
        }

        @Override
        public int getItemViewType(int position) {
            return R.layout.animal_item_view;
        }

        @Override
        public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new AnimalViewHolder(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
        }

        @Override
        public void onBindViewHolder(AnimalViewHolder holder, int position) {
            holder.bind(mAnimals.get(position));
        }

        @Override
        public int getItemCount() {
            return mAnimals.size();
        }
    }


    public static class AnimalViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIv;
        private TextView mTv;
        public AnimalUtils.Animal animal;

        public AnimalViewHolder(View itemView) {
            super(itemView);
            mIv = (ImageView) itemView.findViewById(R.id.iv);
            mTv = (TextView) itemView.findViewById(R.id.tv);
        }

        public void bind(AnimalUtils.Animal a) {
            this.animal = a;
            mTv.setText(animal.getName());
            Glide.with(mIv.getContext())
                    .load(animal.getImageUrl())
                    .into(mIv);

            int color = itemView.getContext().getResources().getColor(R.color.colorAccent);

            itemView.setBackgroundColor(a.isDangerous() ? color: 0x00000000);
        }
    }


}
