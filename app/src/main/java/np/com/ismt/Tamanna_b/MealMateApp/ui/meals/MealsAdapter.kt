package np.com.ismt.Tamanna_b.MealMateApp.ui.meals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import np.com.ismt.Tamanna_b.MealMateApp.databinding.LayoutMealPlanItemBinding
import np.com.ismt.Tamanna_b.MealMateApp.helpers.HelperUtil
import np.com.ismt.Tamanna_b.MealMateApp.models.Recipe
import np.com.ismt.Tamanna_b.MealMateApp.models.WeeklyMealPlan

class MealsAdapter(
    private val recipes: List<Recipe>,
    private val options: FirestoreRecyclerOptions<WeeklyMealPlan>,
): FirestoreRecyclerAdapter<WeeklyMealPlan, MealsAdapter.MealsViewHolder>(options) {

    inner class MealsViewHolder(
        private val binding: LayoutMealPlanItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bindRecipe(mealPlan: WeeklyMealPlan) {
            if (recipes.isEmpty()) {
                return
            }
            val selectedRecipe = recipes.find { it.id == mealPlan.recipeId }
            selectedRecipe?.apply {
                binding.apply {
                    ivMealPlan.setImageBitmap(
                        HelperUtil.base64toBitmap(selectedRecipe.image, root.context)
                    )
                    tvMealPlanName.text = selectedRecipe.name
                    tvMealDescription.text = selectedRecipe.description
                    tvMealCategory.text = selectedRecipe.category
                    tvMealDate.text = mealPlan.date
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LayoutMealPlanItemBinding.inflate(layoutInflater, parent, false)
        return MealsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int, weeklyMealPlan: WeeklyMealPlan) {
        holder.bindRecipe(weeklyMealPlan)
    }
}