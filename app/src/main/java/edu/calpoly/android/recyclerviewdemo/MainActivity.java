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
import android.widget.Toast;

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
                int index = viewHolder.getAdapterPosition();
                if (direction == ItemTouchHelper.LEFT) {
                    Toast.makeText(MainActivity.this, "LEFT", Toast.LENGTH_SHORT).show();
                    AnimalViewHolder avh = (AnimalViewHolder) viewHolder;
                    AnimalUtils.Animal a = avh.animal;

                    a.setDangerous(!a.isDangerous());

                    aa.notifyItemChanged(index);
                } else if (direction == ItemTouchHelper.RIGHT) {
//                    Toast.makeText(MainActivity.this, "RIGHT", Toast.LENGTH_SHORT).show();

                    mAnimals.remove(index);
                    aa.notifyItemRemoved(index);
                }

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rv);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("ANIMALS", mAnimals);
        super.onSaveInstanceState(outState);
    }

    public static class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {

        private ArrayList<AnimalUtils.Animal> mAnimals;

        public AnimalAdapter(ArrayList<AnimalUtils.Animal> a) {
            this.mAnimals = a;
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
            animal = a;

            mTv.setText(a.getName());

            Glide.with(mIv.getContext())
                    .load(a.getImageUrl())
                    .into(mIv);

            int color = a.isDangerous() ? mIv.getResources().getColor(R.color.colorAccent) : 0x00000000;
            itemView.setBackgroundColor(color);
        }
    }

}
