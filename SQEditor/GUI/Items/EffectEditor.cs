using SQEditor.GameObjects.ItemEffects;
using System;
using System.Windows.Forms;

namespace SQEditor.GUI.Items
{
    public partial class EffectEditor : Form
    {
        public ItemEffect effect;

        #region Constructor

        public EffectEditor()
        {
            InitializeComponent();

            effect = new ItemEffect();
        }

        #endregion

        #region Button Clicks

        private void btnSave_Click(object sender, EventArgs e)
        {
            if (HasErrors()) {
                DialogResult = DialogResult.Cancel;
                return;
            }

            effect = new ItemEffect();
            effect.Name = tbDisplayText.Text;
            effect.Script = tbScriptText.Text;

            if (rbEquip.Checked) {
                effect.Type = ItemEffect.EffectType.Equip;
            } else {
                effect.Type = ItemEffect.EffectType.Use;
            }

            DialogResult = DialogResult.OK;
        }

        private bool HasErrors()
        {
            bool result = false;

            errorProvider.SetError(tbDisplayText, "");

            if (String.IsNullOrEmpty(tbDisplayText.Text)) {
                errorProvider.SetError(tbDisplayText, "Effect must have a display name.");
                result = true;
            }

            return result;
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            Close();
        }

        #endregion

        #region Update Remaining Characters

        private void tbScriptText_TextChanged(object sender, EventArgs e)
        {
            var charCount = tbScriptText.Text.Length;
            labelRemainingChars.Text = charCount + " / 250";
        }

        #endregion
    }
}
