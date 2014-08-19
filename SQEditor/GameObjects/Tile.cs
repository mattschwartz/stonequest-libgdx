using System.Collections.Generic;
using System.Drawing;

namespace SQEditor.GameObjects
{
    class Tile
    {
        public enum TileType
        {
            Environment,
            Building,
            Doodad,
            Prop
        }

        public string Name;
        public string StepSound;
        public bool Collision;
        public List<Point> Bounds;
        public TileType Type;

        public Tile()
        {
            Bounds = new List<Point>();
        }
    }
}
